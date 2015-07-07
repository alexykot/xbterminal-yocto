DESCRIPTION = "Virtual Python Environment builder"
HOMEPAGE = "https://virtualenv.pypa.io"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=53df9f8889d6a5fba83f425abe3b1568"

SRC_URI = "https://pypi.python.org/packages/source/v/virtualenv/virtualenv-${PV}.tar.gz"
SRC_URI[md5sum] = "f61cdd983d2c4e6aeabb70b1060d6f49"
SRC_URI[sha256sum] = "3e7a4c151e2ee97f51db0215bfd2a073b04a91e9786df6cb67c916f16abe04f7"

inherit setuptools

S = "${WORKDIR}/virtualenv-${PV}"
