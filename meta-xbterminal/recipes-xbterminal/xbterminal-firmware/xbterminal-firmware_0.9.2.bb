DESCRIPTION = "XBTerminal firmware"
HOMEPAGE = "https://xbterminal.io"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e8d19d5cef2e63c0791389e1e3496c4"

SRC_URI = "file://device_key \
           file://secret_key \
           file://local_state"
SRC_URI_append_wandboard-solo = " file://xbterminal-firmware-${PV}-armhf.tar.gz"
SRC_URI_append_qemuarm = " file://xbterminal-firmware-${PV}-armel.tar.gz"

S_wandboard-solo = "${WORKDIR}/xbterminal-firmware-${PV}-armhf"
S_qemuarm = "${WORKDIR}/xbterminal-firmware-${PV}-armel"

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

    cp ${WORKDIR}/device_key ${D}${servicedir}/xbterminal/xbterminal/
    cp ${WORKDIR}/secret_key ${D}${servicedir}/xbterminal/xbterminal/runtime/
    cp ${WORKDIR}/local_state ${D}${servicedir}/xbterminal/xbterminal/runtime/
}

FILES_${PN} = "${servicedir}/xbterminal"

INHIBIT_PACKAGE_STRIP = "1"
