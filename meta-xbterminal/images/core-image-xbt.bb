SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "splash package-management"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "\
    xinit xset git nano htop usbutils \
    gcc glibc libc6-dev python-dev \
    python-pyqt python-dbus \
    python-pip python-pyusb python-pybluez python-cffi python-virtualenv \
    "
