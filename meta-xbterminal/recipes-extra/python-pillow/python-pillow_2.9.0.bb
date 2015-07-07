DESCRIPTION = "Python Imaging Library (Fork)"
HOMEPAGE = "https://python-pillow.github.io/"
LICENSE = "Standard-PIL-License"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f03075aa611d08bd0612dada2baba4cc"

SRC_URI = "https://pypi.python.org/packages/source/P/Pillow/Pillow-${PV}.tar.gz"
SRC_URI[md5sum] = "46f1729ece27981d54ec543ad5b37d14"
SRC_URI[sha256sum] = "0f179d7e75e7c83b6341b9595ca1f394de7081484a9e352ad66d553a1c3daa29"

S = "${WORKDIR}/Pillow-${PV}"

inherit setuptools
