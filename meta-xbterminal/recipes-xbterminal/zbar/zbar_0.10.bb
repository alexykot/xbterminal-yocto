DESCRIPTION = "ZBar bar code reader"
HOMEPAGE = "http://zbar.sourceforge.net/"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=243b725d71bb5df4a1e5920b344b86ad"

PR = "r2"

SRC_URI = "http://sourceforge.mirrorservice.org/z/zb/zbar/zbar/0.10/zbar-0.10.tar.gz \
           file://disable_warnings.patch \
           file://fix_python_include.patch \
           file://fix_v4l1_header_name.patch \
           file://fix_v4l1_include.patch \
           file://fix_segfault_on_import.patch"
SRC_URI[md5sum] = "5ffa99933d01835de59bf1e1c849d851"
SRC_URI[sha256sum] = "575fa82de699faa7bda2d2ebbe3e1af0a4152ec4d3ad72c0ab6712d7cc9b5dd2"

inherit autotools pkgconfig python-dir distutils-base gettext

DEPENDS += "v4l-utils jpeg libxv libice libsm"

EXTRA_OECONF = " --without-imagemagick --without-qt --without-gtk"
