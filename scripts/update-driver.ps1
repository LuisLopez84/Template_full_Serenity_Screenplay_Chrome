$DRIVERS_DIRECTORY = "src\main\resources\drivers"

function validate_versions {
    $PLATFORM = (Get-WmiObject -Class Win32_Processor).AddressWidth
    switch ($PLATFORM) {
        "64" {
            $global:PLATFORM_EDGE = "win64"
            $global:PLATFORM_CHROME = "win64"
            $LOCATION_BROWSER_EDGE = "C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"
            $LOCATION_BROWSER_CHROME = "C:\Program Files\Google\Chrome\Application\chrome.exe"
        }
        "32" {
            $global:PLATFORM_EDGE = "win32"
            $global:PLATFORM_CHROME = "win32"
            $LOCATION_BROWSER_EDGE = "C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"
            $LOCATION_BROWSER_CHROME = "C:\Program Files\Google\Chrome\Application\chrome.exe"
        }
        default {
            Write-Host "Platform $PLATFORM is invalid"
        }
    }
    if (Test-Path $LOCATION_BROWSER_EDGE) {
        $global:VERSION_FULL_EDGE_BROWSER = (Get-Item $LOCATION_BROWSER_EDGE).VersionInfo.FileVersion
        if (Test-Path "$DRIVERS_DIRECTORY\msedgedriver.exe") {
            if(cmd /c "$DRIVERS_DIRECTORY\msedgedriver.exe -v" | ForEach-Object { $_ -match '(\d+\.\d+\.\d+\.\d+)' }){
                $global:VERSION_EDGE_DRIVER = $Matches[1]
            }else{
                Write-Error "No se encontro la version de Edgedriver"
            }
        }else{
            $global:VERSION_EDGE_DRIVER = 0
        }
    }else{
        Write-Host "Navegador Edge no existe o la ruta es incorrecta, saltando.."
    }
    if (Test-Path $LOCATION_BROWSER_CHROME) {
        $global:VERSION_MAJOR_CHROME_BROWSER = (Get-Item $LOCATION_BROWSER_CHROME).VersionInfo.FileVersion | ForEach-Object { $_ -split '\.' } | Select-Object -Index 0
        if (Test-Path "$DRIVERS_DIRECTORY\chromedriver.exe") {
            $global:VERSION_MAJOR_CHROME_DRIVER = cmd /c "$DRIVERS_DIRECTORY\chromedriver.exe -v" | ForEach-Object { $_ -replace ' ', '.' } | ForEach-Object { $_ -split '\.' } | Select-Object -Index 1
        }else{
            $global:VERSION_MAJOR_CHROME_DRIVER = 0
        }
    }else{
        Write-Host "Navegador Chrome no existe o la ruta es incorrecta, saltando.."
    }
}

function install_drivers {
    if ($global:VERSION_FULL_EDGE_BROWSER -ne $global:VERSION_EDGE_DRIVER) {
        try {
            Write-Host "Instalando la version $global:VERSION_FULL_EDGE_BROWSER de Edgedriver"
            Invoke-WebRequest -Uri "https://msedgedriver.azureedge.net/$global:VERSION_FULL_EDGE_BROWSER/edgedriver_$global:PLATFORM_EDGE.zip" -OutFile "$DRIVERS_DIRECTORY\edgedriver_$global:PLATFORM_EDGE.zip"
            Expand-Archive -Path "$DRIVERS_DIRECTORY\edgedriver_$global:PLATFORM_EDGE.zip" -DestinationPath $DRIVERS_DIRECTORY -Force
            Write-Host "Driver de Edge instalado exitosamente"
            try {
                Remove-Item -Path "$DRIVERS_DIRECTORY\edgedriver_$global:PLATFORM_EDGE.zip" -Force
                Remove-Item -Path "$DRIVERS_DIRECTORY\Driver_Notes" -Recurse -Force
                Write-Host "Archivos basura eliminados correctamente"
            }
            catch {
                Write-Error "Error al eliminar los archivos basura"
            }
        }
        catch {
            Write-Error "Hubo un error al instalar el driver de Edge"
        }
    } else {
        if($null -ne $global:VERSION_FULL_EDGE_BROWSER){
            Write-Host "El driver de Edge ya esta actualizado con su navegador"
        }
    }
    if ($global:VERSION_MAJOR_CHROME_BROWSER -ne $global:VERSION_MAJOR_CHROME_DRIVER) {
        try {
            if ($global:VERSION_MAJOR_CHROME_BROWSER -ge 114) {
                $VERSION_INSTALL_CHROME_DRIVER = Invoke-RestMethod -Uri "https://googlechromelabs.github.io/chrome-for-testing/LATEST_RELEASE_$global:VERSION_MAJOR_CHROME_BROWSER"
                Write-Host "Instalando la version $VERSION_INSTALL_CHROME_DRIVER de Chromedriver"
                Invoke-WebRequest -Uri "https://storage.googleapis.com/chrome-for-testing-public/$VERSION_INSTALL_CHROME_DRIVER/$global:PLATFORM_CHROME/chromedriver-$global:PLATFORM_CHROME.zip" -OutFile "$DRIVERS_DIRECTORY\chromedriver-$global:PLATFORM_CHROME.zip"
                Expand-Archive -Path "$DRIVERS_DIRECTORY\chromedriver-$global:PLATFORM_CHROME.zip" -DestinationPath $DRIVERS_DIRECTORY -Force
                Move-Item -Path "$DRIVERS_DIRECTORY\chromedriver-$global:PLATFORM_CHROME/chromedriver.exe" -Destination $DRIVERS_DIRECTORY
            } else {
                Write-Error "Actualice su navegador de Chrome a una version mayor a la 114"
            }
            try {
                Remove-Item -Path "$DRIVERS_DIRECTORY\chromedriver-$global:PLATFORM_CHROME.zip" -Force
                Remove-Item -Path "$DRIVERS_DIRECTORY\chromedriver-$global:PLATFORM_CHROME" -Recurse -Force
                Write-Host "Archivos basura eliminados correctamente"
            }
            catch {
                Write-Error "Error al eliminar los archivos basura"
            }
        }
        catch {
            Write-Error "Hubo un error al instalar el driver de Chrome"
        }
    } else {
        if($null -ne $global:VERSION_MAJOR_CHROME_BROWSER){
            Write-Host "El driver de Chrome ya esta actualizado con su navegador"
        }
    }
}

validate_versions
install_drivers
