DESCRIPTION = "Internationalized Domain Names in Applications (IDNA)"
HOMEPAGE = "https://github.com/kjd/idna"
LICENSE = "BSD-like"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=c61e6ec7ab3da6b340d8d3a89c964ef2"

SRC_URI = "https://pypi.python.org/packages/source/i/idna/idna-${PV}.tar.gz"
SRC_URI[md5sum] = "bd17a9d15e755375f48a62c13b25b801"
SRC_URI[sha256sum] = "16199aad938b290f5be1057c0e1efc6546229391c23cea61ca940c115f7d3d3b"

inherit setuptools

S = "${WORKDIR}/idna-${PV}"
