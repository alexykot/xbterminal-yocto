DESCRIPTION = "XBTerminal firmware"
HOMEPAGE = "https://xbterminal.io"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e8d19d5cef2e63c0791389e1e3496c4"

PR = "r1"

SRC_URI_wandboard-solo = " file://xbterminal-firmware_armhf_${PV}.tar.gz"
SRC_URI_qemuarm = " file://xbterminal-firmware_armel_${PV}.tar.gz"

S_wandboard-solo = "${WORKDIR}/xbterminal-firmware_armhf_${PV}"
S_qemuarm = "${WORKDIR}/xbterminal-firmware_armel_${PV}"

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
    fswebcam"

do_install () {
    mkdir -p ${D}${servicedir}/xbterminal
    cp -r ${S}/xbterminal ${D}${servicedir}/xbterminal/
    chmod 755 ${D}${servicedir}/xbterminal/xbterminal/main

    echo ${XBTERMINAL_BATCH_NUMBER} > ${D}${servicedir}/xbterminal/xbterminal/runtime/batch_number
}

FILES_${PN} = "${servicedir}/xbterminal"

INHIBIT_PACKAGE_STRIP = "1"
