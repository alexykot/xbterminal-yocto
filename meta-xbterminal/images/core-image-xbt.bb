SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "splash package-management ssh-server-openssh"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "\
    packagegroup-core-x11-xserver xinit xset \
    git nano htop usbutils ntp \
    zbar fswebcam \
    python-pyqt python-dbus python-imaging \
    python-pip python-pyusb python-pybluez python-cryptography \
    python-qrcode python-wifi python-requests \
    python-psutil python-ntplib python-protobuf python-adafruit-bbio \
    python-nfcpy \
    "

# Set root password
inherit extrausers
EXTRA_USERS_PARAMS = "usermod -P root root;"
