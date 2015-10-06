DESCRIPTION = "XBTerminal firmware"
HOMEPAGE = "https://xbterminal.io"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e8d19d5cef2e63c0791389e1e3496c4"

python () {
    version = d.getVar('PV', True)
    if not d.getVar('XBTFW_VERSION_FULL', True):
        d.setVar('XBTFW_VERSION_FULL', version)
}

INC_PR = "r1"

SRC_URI_wandboard-solo = " file://xbterminal-firmware_${XBTFW_VERSION_FULL}_armhf.tar.gz"
SRC_URI_qemuarm = " file://xbterminal-firmware_${XBTFW_VERSION_FULL}_armel.tar.gz"

S_wandboard-solo = "${WORKDIR}/xbterminal-firmware_${XBTFW_VERSION_FULL}_armhf"
S_qemuarm = "${WORKDIR}/xbterminal-firmware_${XBTFW_VERSION_FULL}_armel"

SRC_URI_append = " file://xbterminal-firmware.service \
                   file://xbterminal-x.service \
                 "

inherit systemd
SYSTEMD_PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    python-modules \
    python-pyqt \
    python-dbus \
    python-imaging \
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
    ttf-dejavu-sans \
    "

do_install () {
    mkdir -p ${D}${servicedir}/xbterminal
    cp -r ${S}/xbterminal ${D}${servicedir}/xbterminal/
    chmod 755 ${D}${servicedir}/xbterminal/xbterminal/main
    install -d ${D}${systemd_unitdir}/system/ 
    install -m 0644 ${WORKDIR}/${PN}.service ${D}${systemd_unitdir}/system/${PN}.service
    install -m 0644 ${WORKDIR}/xbterminal-x.service ${D}${systemd_unitdir}/system/xbterminal-x.service

}

FILES_${PN} = "${servicedir}/xbterminal \ 
               ${systemd_unitdir}/system/${PN}.service \
               ${systemd_unitdir}/system/xbterminal-x.service \
              "

INHIBIT_PACKAGE_STRIP = "1"
