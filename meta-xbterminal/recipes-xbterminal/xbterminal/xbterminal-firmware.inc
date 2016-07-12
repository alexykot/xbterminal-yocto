require xbterminal.inc

DESCRIPTION = "XBTerminal firmware"
HOMEPAGE = "https://xbterminal.io"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e8d19d5cef2e63c0791389e1e3496c4"

INC_PR = "r13"

SRC_URI_append = " file://xbterminal-x.service \
                   file://xbterminal-firmware.service \
                 "

inherit systemd
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "${PN}.service"

RDEPENDS_${PN} += "\
    python-pyqt \
    icu \
    qt4-plugin-imageformat-gif \
    ttf-dejavu-sans \
    xbterminal-firmware-theme-default \
    "

do_install () {
    xbtdir=${D}${servicedir}/xbterminal/xbterminal
    mkdir -p ${xbtdir}
    install -m 0755 ${S}/xbterminal/main ${xbtdir}/main
    install -d ${xbtdir}/runtime
    install -d ${xbtdir}/gui
    install -d ${xbtdir}/gui/themes
    install -m 0644 ${S}/xbterminal/gui/themes/*.so ${xbtdir}/gui/themes/
    install -d ${xbtdir}/gui/ts
    install -m 0644 ${S}/xbterminal/gui/ts/*.qm ${xbtdir}/gui/ts/

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/${PN}.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} = "${servicedir}/xbterminal/xbterminal/main \
               ${servicedir}/xbterminal/xbterminal/runtime \
               ${servicedir}/xbterminal/xbterminal/gui/ts \
               ${systemd_unitdir}/system/xbterminal-x.service \
               ${systemd_unitdir}/system/xbterminal-firmware.service \
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
