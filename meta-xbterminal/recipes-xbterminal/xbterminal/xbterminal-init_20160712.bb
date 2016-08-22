DESCRIPTION = "XBTerminal device initialization script"
HOMEPAGE = "https://xbterminal.io"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=294d69613fe1e7f0f5c33ab96bbc5eb8"

PR = "r2"

SRC_URI = "file://xbterminal-init.service \
           file://xbt-init \
           file://LICENSE"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "${PN}.service"

RDEPENDS_${PN} = "\
    wget \
    salt-minion \
    xbterminal-rpc"

do_install () {
    install -d ${D}${bindir}/
    install -m 0755 ${WORKDIR}/xbt-init ${D}${bindir}/xbt-init

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/${PN}.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} = "${systemd_unitdir}/system/xbterminal-init.service \
               ${bindir}/xbt-init"
