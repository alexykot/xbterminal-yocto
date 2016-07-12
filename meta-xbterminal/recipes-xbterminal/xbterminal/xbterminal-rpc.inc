require xbterminal.inc

DESCRIPTION = "XBTerminal JSON-RPC server"
HOMEPAGE = "https://xbterminal.io"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e8d19d5cef2e63c0791389e1e3496c4"

INC_PR = "r0"

SRC_URI_append = " file://xbterminal-rpc.service "

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "${PN}.service"

RDEPENDS_${PN} += "\
    python-json-rpc \
    python-tornado \
    "
PROVIDES += "xbterminal-app"
RPROVIDES_${PN} += "xbterminal-app"
RCONFLICTS_${PN} = "xbterminal-firmware"

do_install () {
    xbtdir=${D}${servicedir}/xbterminal/xbterminal

    mkdir -p ${xbtdir}
    install -m 0755 ${S}/xbterminal/main_rpc ${xbtdir}/main_rpc
    install -d ${xbtdir}/runtime

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/${PN}.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} = "${servicedir}/xbterminal/xbterminal/main_rpc \
               ${servicedir}/xbterminal/xbterminal/runtime \
               ${systemd_unitdir}/system/xbterminal-rpc.service \
              "

INHIBIT_PACKAGE_STRIP = "1"
