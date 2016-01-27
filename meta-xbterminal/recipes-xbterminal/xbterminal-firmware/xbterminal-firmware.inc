DESCRIPTION = "XBTerminal firmware"
HOMEPAGE = "https://xbterminal.io"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e8d19d5cef2e63c0791389e1e3496c4"

INC_PR = "r9"

def get_pkgv(d):
    return d.getVar('XBTFW_PKGV', True) or d.getVar('PV', True)

PKGV = "${@get_pkgv(d)}"

SRC_URI_wandboard = " file://xbterminal-firmware_${PKGV}_armhf.tar.gz"
SRC_URI_imx6ulevk = " file://xbterminal-firmware_${PKGV}_armhf.tar.gz"
SRC_URI_qemuarm = " file://xbterminal-firmware_${PKGV}_armel.tar.gz"

S_wandboard = "${WORKDIR}/xbterminal-firmware_${PKGV}_armhf"
S_imx6ulevk = "${WORKDIR}/xbterminal-firmware_${PKGV}_armhf"
S_qemuarm = "${WORKDIR}/xbterminal-firmware_${PKGV}_armel"

SRC_URI_append = " file://xbterminal-init.service \
                   file://xbterminal-x.service \
                   file://xbterminal-firmware.service \
                   file://xbt-init \
                 "

inherit systemd
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "xbterminal-init.service xbterminal-firmware.service"

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
    python-itl-bsp \
    xbterminal-firmware-theme-default \
    "

do_install () {
    mkdir -p ${D}${servicedir}/xbterminal
    cp -r ${S}/xbterminal ${D}${servicedir}/xbterminal/
    chmod 755 ${D}${servicedir}/xbterminal/xbterminal/main

    install -d ${D}${bindir}/
    install -m 0755 ${WORKDIR}/xbt-init ${D}${bindir}/xbt-init

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/*.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} = "${servicedir}/xbterminal/xbterminal/main \
               ${servicedir}/xbterminal/xbterminal/runtime \
               ${servicedir}/xbterminal/xbterminal/gui/ts \
               ${systemd_unitdir}/system/xbterminal-init.service \
               ${systemd_unitdir}/system/xbterminal-x.service \
               ${systemd_unitdir}/system/xbterminal-firmware.service \
               ${bindir}/xbt-init \
              "

python populate_packages_prepend () {
    themes_dir = d.expand('${servicedir}/xbterminal/xbterminal/gui/themes/')
    theme_pn = d.expand('${PN}-theme-%s')
    do_split_packages(
        d,
        themes_dir,
        '^(.+)\.so$',
        theme_pn,
        'XBTerminal firmware - UI theme %s')
}

PACKAGES_DYNAMIC = "${PN}-theme-.*"

INHIBIT_PACKAGE_STRIP = "1"
