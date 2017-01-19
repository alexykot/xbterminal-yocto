DESCRIPTION = "ZBar bar code reader"
HOMEPAGE = "http://zbar.sourceforge.net/"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=243b725d71bb5df4a1e5920b344b86ad"

PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.bz2 \
           file://disable_warnings.patch \
           file://fix_python_include.patch \
           file://fix_v4l1_header_name.patch \
           file://fix_v4l1_include.patch \
           file://fix_segfault_on_import.patch"
SRC_URI[md5sum] = "0fd61eb590ac1bab62a77913c8b086a5"
SRC_URI[sha256sum] = "234efb39dbbe5cef4189cc76f37afbe3cfcfb45ae52493bfe8e191318bdbadc6"

inherit autotools pkgconfig python-dir distutils-base gettext

DEPENDS += "v4l-utils jpeg libxv libice libsm"

EXTRA_OECONF = " --without-imagemagick --without-qt --without-gtk"
