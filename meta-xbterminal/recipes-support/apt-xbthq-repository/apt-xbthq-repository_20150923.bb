PR = "r1"

DESCRIPTION = "XBTerminal HQ Repository"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=4eed5be50c30ca03c23569314c3895ec"

RDEPENDS_${PN} = "\
                 xbthq-certificates \ 
                 "

DEPENDS_${PN} += " apt "
SRC_URI = " file://00ssl-xbt-client-auth \
            file://xbt-dev.list \
            file://LICENSE \
            file://xbt.key \
            file://xbt.crt \
            file://xbt_dev_signing.key \
            file://trusted.gpg \
          "

inherit allarch

S = "${WORKDIR}"

do_install () {
	install -d ${D}/${sysconfdir}/apt/apt.conf.d/
	install -m 0644 ${WORKDIR}/00ssl-xbt-client-auth ${D}${sysconfdir}/apt/apt.conf.d/00ssl-xbt-client-auth

        install -d ${D}/${sysconfdir}/apt/sources.list.d/
        install -m 0644 ${WORKDIR}/xbt-dev.list ${D}${sysconfdir}/apt/sources.list.d/xbt-dev.list

	install -m 0644 ${WORKDIR}/xbt.key ${D}${sysconfdir}/apt/xbt.key
	install -m 0644 ${WORKDIR}/xbt.crt ${D}${sysconfdir}/apt/xbt.crt
        
        install -m 0644 ${WORKDIR}/xbt_dev_signing.key ${D}${sysconfdir}/apt/xbt_dev_signing.key
	install -m 0644 ${WORKDIR}/trusted.gpg ${D}${sysconfdir}/apt/trusted.gpg
} 

FILES_${PN} += "\
		${sysconfdir}/apt/apt.conf.d/00ssl-xbt-client-auth \
		${sysconfdir}/apt/sources.list.d/xbt-dev.list \
		${sysconfdir}/apt/xbt_dev_signing.key \
                ${sysconfdir}/apt/xbt.key \
                ${sysconfdir}/apt/xbt.crt \
		${sysconfdir}/apt/trusted.gpg \
		"

pkg_postinst_${PN} () {
#!/bin/sh  
if [ -n "$D" ]; then
        exit 0
fi
apt-key --keyring $D${sysconfdir}/apt/trusted.gpg finger  | true
apt-key --keyring $D${sysconfdir}/apt/trusted.gpg add $D${sysconfdir}/apt/xbt_dev_signing.key | true

}

INHIBIT_PACKAGE_STRIP = "1"

