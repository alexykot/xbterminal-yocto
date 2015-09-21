DESCRIPTION = "XBTerminal firmware"
HOMEPAGE = "https://xbterminal.io"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e8d19d5cef2e63c0791389e1e3496c4"

SRC_URI_wandboard-solo = " file://xbterminal-firmware_${PV}_armhf.tar.gz"
SRC_URI_qemuarm = " file://xbterminal-firmware_${PV}_armel.tar.gz"

S_wandboard-solo = "${WORKDIR}/xbterminal-firmware_${PV}_armhf"
S_qemuarm = "${WORKDIR}/xbterminal-firmware_${PV}_armel"

RDEPENDS_${PN} = "\
    python-pyqt \
    python-dbus \
    python-imaging \
    python-pip \
    python-pyusb \
    python-pybluez \
    python-cryptography \
    python-qrcode \
    python-wifi \
    python-requests \
    python-psutil \
    python-ntplib \
    python-protobuf \
    python-adafruit-bbio \
    python-nfcpy \
    zbar \
    fswebcam \
    icu \
    qt4-plugin-imageformat-gif \
    "

do_install () {
    mkdir -p ${D}${servicedir}/xbterminal
    cp -r ${S}/xbterminal ${D}${servicedir}/xbterminal/
    chmod 755 ${D}${servicedir}/xbterminal/xbterminal/main
}

FILES_${PN} = "${servicedir}/xbterminal"

INHIBIT_PACKAGE_STRIP = "1"