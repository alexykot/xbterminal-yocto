DESCRIPTION = "Python library which exposes cryptographic recipes and primitives"
HOMEPAGE = "https://cryptography.io/"
LICENSE = "Apache-2.0 & BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8c3617db4fb6fae01f1d253ab91511e4"

PR = "r4"

SRC_URI = "https://pypi.python.org/packages/source/c/cryptography/cryptography-${PV}.tar.gz"
SRC_URI[md5sum] = "70af3fbce7683b31d173eba225f18650"
SRC_URI[sha256sum] = "aed022f738dd9adb840d92960b0464ea1fbb222ba118938858eb93fe25151c2d"

inherit setuptools

S = "${WORKDIR}/cryptography-${PV}"

DEPENDS += "\
    python-cffi-native \
    python-cffi \
    python-enum34 \
    python-six \
    python-pyasn1 \
    python-ipaddress \
    python-idna"

RDEPENDS_${PN} = "\
    python-cffi \
    python-six \
    python-misc \
    python-enum34 \
    python-ipaddress \
    python-idna \
    python-setuptools"
