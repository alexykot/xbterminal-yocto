SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "splash package-management"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "\
    xinit xset git nano htop usbutils \
    python-pyqt python-dbus python-imaging \
    python-pip python-pyusb python-pybluez python-cryptography \
    python-qrcode python-wifi python-requests \
    "
