DESCRIPTION = "Python library which exposes cryptographic recipes and primitives"
HOMEPAGE = "https://cryptography.io/"
LICENSE = "Apache-2.0 & BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8c3617db4fb6fae01f1d253ab91511e4"

PR = "r1"

SRC_URI[md5sum] = "bc8148d2ff2d80fef8ef2d2e856b3a7f"
SRC_URI[sha256sum] = "b4b36175e0f95ddc88435c26dbe3397edce48e2ff5fe41d504cdb3beddcd53e2"

inherit pypi

DEPENDS += "\
    python-cffi-native \
    python-cffi \
    python-enum34 \
    python-six \
    python-pyasn1 \
    python-ipaddress \
    python-idna"

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
