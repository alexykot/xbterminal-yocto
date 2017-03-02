DESCRIPTION = "Python library which exposes cryptographic recipes and primitives"
HOMEPAGE = "https://cryptography.io/"
LICENSE = "Apache-2.0 & BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d5ede125ed08d4fd14ec44d334bdb388"

inherit pypi

DEPENDS += "\
    python-cffi-native \
    python-cffi \
    python-six \
    python-pyasn1 \
    "

RDEPENDS_${PN} = "\
    python-misc \
    python-setuptools \
    python-cffi \
    python-pycparser \
    python-enum34 \
    python-six \
    python-pyasn1 \
    python-ipaddress \
    python-idna"

FILES_${PN}-dbg += " ${PYTHON_SITEPACKAGES_DIR}/*/*/*/.debug"
