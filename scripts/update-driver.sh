#!/bin/bash

DRIVERS_DIRECTORY="src/main/resources/drivers"

validate_versions(){
    PLATFORM=$(uname -sm)
    case "$PLATFORM" in
        "Darwin arm64")
            PLATFORM_EDGE="arm64"
            PLATFORM_CHROME="mac-arm64"
            LOCATION_BROWSER_EDGE="/Applications/Microsoft Edge.app/Contents/MacOS/Microsoft Edge"
            LOCATION_BROWSER_CHROME="/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"
            shift
            ;;
        "Darwin x86_64")
            PLATFORM_EDGE="mac64"
            PLATFORM_CHROME="mac-x64"
            LOCATION_BROWSER_EDGE="/Applications/Microsoft Edge.app/Contents/MacOS/Microsoft Edge"
            LOCATION_BROWSER_CHROME="/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"
            shift
            ;;
        "Linux x86_64")
            PLATFORM_EDGE="linux64"
            PLATFORM_CHROME="linux64"
            LOCATION_BROWSER_EDGE="microsoft-edge"
            LOCATION_BROWSER_CHROME="google-chrome"
            shift
            ;;
        *)
            echo "Platform $PLATFORM is invalid"
            exit 1
            ;;
    esac

    VERSION_FULL_EDGE_BROWSER=$("$LOCATION_BROWSER_EDGE" --version | tr -s ' ' '.' | cut -d "." -f 3,4,5,6)
    VERSION_MAJOR_CHROME_BROWSER=$("$LOCATION_BROWSER_CHROME" --version | tr -s ' ' '.' | cut -d "." -f 3)
    VERSION_EDGE_DRIVER="$($DRIVERS_DIRECTORY/msedgedriver -v | tr -s ' ' '.' | cut -d "." -f 4,5,6,7)"
    VERSION_MAJOR_CHROME_DRIVER="$($DRIVERS_DIRECTORY/chromedriver -v | tr -s ' ' '.' | cut -d "." -f 2)"
}

install_drivers(){
    if [ "$VERSION_FULL_EDGE_BROWSER" != "$VERSION_EDGE_DRIVER" ]; then
        wget -P $DRIVERS_DIRECTORY https://msedgedriver.azureedge.net/$VERSION_FULL_EDGE_BROWSER/edgedriver_$PLATFORM_EDGE.zip
        unzip -j -o $DRIVERS_DIRECTORY/edgedriver_$PLATFORM_EDGE.zip -d $DRIVERS_DIRECTORY
        rm -r $DRIVERS_DIRECTORY/edgedriver_$PLATFORM_EDGE.zip
        rm -r $DRIVERS_DIRECTORY/Driver_Notes
    else
        echo "El driver de Edge ya esta actualizado con su navegador"
    fi

    if [ "$VERSION_MAJOR_CHROME_BROWSER" != "$VERSION_MAJOR_CHROME_DRIVER" ]; then
        # https://chromedriver.chromium.org/downloads/version-selection
        if [ $VERSION_MAJOR_CHROME_BROWSER -ge 114 ]; then
            VERSION_INSTALL_CHROME_DRIVER=$(curl https://googlechromelabs.github.io/chrome-for-testing/LATEST_RELEASE_$VERSION_MAJOR_CHROME_BROWSER)
            wget -P $DRIVERS_DIRECTORY https://storage.googleapis.com/chrome-for-testing-public/$VERSION_INSTALL_CHROME_DRIVER/$PLATFORM_CHROME/chromedriver-$PLATFORM_CHROME.zip
            unzip -j -o $DRIVERS_DIRECTORY/chromedriver-$PLATFORM_CHROME.zip -d $DRIVERS_DIRECTORY
            mv $DRIVERS_DIRECTORY/chromedriver-$PLATFORM_CHROME/chromedriver $DRIVERS_DIRECTORY
            rm -r $DRIVERS_DIRECTORY/LICENSE.chromedriver && rm -r $DRIVERS_DIRECTORY/LICENSE && rm -r $DRIVERS_DIRECTORY/EULA && rm -r $DRIVERS_DIRECTORY/credits.html && rm -r $DRIVERS_DIRECTORY/chromedriver-$PLATFORM_CHROME.zip
        else
            echo "Actualice su navegador a una version mayor a la 114"
        fi
    else
        echo "El driver de Chrome ya esta actualizado con su navegador"
    fi
}

validate_versions
install_drivers
