DESCRIPTION = "Manage swap file"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PR = "r0"

SRC_URI = "\
    file://swapfile \
    file://swapfile.service \
    "

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "swapfile.service"

RDEPENDS_${PN} = "util-linux"

do_install () {
    install -d ${D}${bindir}/
    install -m 0700 ${WORKDIR}/swapfile ${D}${bindir}/swapfile
    
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/swapfile.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} = "\
    ${bindir}/swapfile \
    ${systemd_unitdir}/system/swapfile.service \
    "
