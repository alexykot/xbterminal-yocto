DESCRIPTION = "XBTerminal HQ Repository"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=4eed5be50c30ca03c23569314c3895ec"

PR = "r3"

RDEPENDS_${PN} = "\
                 xbthq-certificates \
                 "

DEPENDS_${PN} += " apt "
SRC_URI = " file://00ssl-xbt-client-auth \
            file://LICENSE \
            file://xbt.key \
            file://xbt.crt \
            file://xbt_dev_signing.key \
            file://trusted.gpg \
            file://xbt-dev_${MACHINE}.list \
          "

inherit allarch

S = "${WORKDIR}"

do_install () {
    install -d ${D}/${sysconfdir}/apt/apt.conf.d/
    install -m 0644 ${WORKDIR}/00ssl-xbt-client-auth ${D}${sysconfdir}/apt/apt.conf.d/00ssl-xbt-client-auth

    install -d ${D}/${sysconfdir}/apt/sources.list.d/
    install -m 0644 ${WORKDIR}/xbt-dev_${MACHINE}.list ${D}${sysconfdir}/apt/sources.list.d/xbt-dev_${MACHINE}.list

    install -m 0644 ${WORKDIR}/xbt.key ${D}${sysconfdir}/apt/xbt.key
    install -m 0644 ${WORKDIR}/xbt.crt ${D}${sysconfdir}/apt/xbt.crt

    install -m 0644 ${WORKDIR}/xbt_dev_signing.key ${D}${sysconfdir}/apt/xbt_dev_signing.key
    install -m 0644 ${WORKDIR}/trusted.gpg ${D}${sysconfdir}/apt/trusted.gpg
}

FILES_${PN} += "\
    ${sysconfdir}/apt/apt.conf.d/00ssl-xbt-client-auth \
    ${sysconfdir}/apt/sources.list.d/xbt-dev_${MACHINE}.list \
    ${sysconfdir}/apt/xbt_dev_signing.key \
    ${sysconfdir}/apt/xbt.key \
    ${sysconfdir}/apt/xbt.crt \
    ${sysconfdir}/apt/trusted.gpg \
    "


CONFFILES_${PN} += "\
    ${sysconfdir}/apt/apt.conf.d/00ssl-xbt-client-auth \
    ${sysconfdir}/apt/sources.list.d/xbt-dev_${MACHINE}.list \
    ${sysconfdir}/apt/xbt.key \
    ${sysconfdir}/apt/xbt.crt \
    ${sysconfdir}/apt/trusted.gpg \
    "

pkg_postinst_${PN} () {
    apt-key --keyring ${sysconfdir}/apt/trusted.gpg add ${sysconfdir}/apt/xbt_dev_signing.key
}

INHIBIT_PACKAGE_STRIP = "1"
