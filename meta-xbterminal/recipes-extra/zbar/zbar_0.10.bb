DESCRIPTION = "ZBar bar code reader"
HOMEPAGE = "http://zbar.sourceforge.net/"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "${SOURCEFORGE_MIRROR}/zbar/zbar-0.10.tar.bz2"
SRC_URI[md5sum] = "0fd61eb590ac1bab62a77913c8b086a5"
SRC_URI[sha256sum] = "234efb39dbbe5cef4189cc76f37afbe3cfcfb45ae52493bfe8e191318bdbadc6"

inherit autotools pkgconfig

DEPENDS = "gettext"
