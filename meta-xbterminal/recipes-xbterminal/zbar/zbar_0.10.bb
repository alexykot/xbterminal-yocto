DESCRIPTION = "ZBar bar code reader"
HOMEPAGE = "http://zbar.sourceforge.net/"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=243b725d71bb5df4a1e5920b344b86ad"

PR = "r1"

SRC_URI = "https://pypi.python.org/packages/source/z/zbar/zbar-0.10.tar.bz2 \
           file://disable_warnings.patch \
           file://fix_python_include.patch \
           file://fix_v4l1_header_name.patch \
           file://fix_v4l1_include.patch \
           file://fix_segfault_on_import.patch"
SRC_URI[md5sum] = "f82f03485a504538314d7d11b7450178"
SRC_URI[sha256sum] = "597dc972199341426d74e9edc42dbde76c6ee6a884ec2039a81d266300a6d46b"

inherit autotools pkgconfig python-dir distutils-base gettext

DEPENDS += "v4l-utils jpeg libxv libice libsm"

EXTRA_OECONF = " --without-imagemagick --without-qt --without-gtk"
