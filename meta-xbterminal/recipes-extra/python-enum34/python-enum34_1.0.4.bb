DESCRIPTION = "Python 3.4 Enum backported to 3.3, 3.2, 3.1, 2.7, 2.6, 2.5, and 2.4"
HOMEPAGE = "https://pypi.python.org/pypi/enum34"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://enum/LICENSE;md5=0a97a53a514564c20efd7b2e8976c87e"

SRC_URI = "https://pypi.python.org/packages/source/e/enum34/enum34-${PV}.tar.gz"
SRC_URI[md5sum] = "ac80f432ac9373e7d162834b264034b6"
SRC_URI[sha256sum] = "d3c19f26a6a34629c18c775f59dfc5dd595764c722b57a2da56ebfb69b94e447"

inherit setuptools

S = "${WORKDIR}/enum34-${PV}"
