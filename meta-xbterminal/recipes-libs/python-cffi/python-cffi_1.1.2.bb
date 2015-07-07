DESCRIPTION = "Foreign Function Interface for Python calling C code"
HOMEPAGE = "https://cffi.readthedocs.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5677e2fdbf7cdda61d6dd2b57df547bf"

SRC_URI = "https://pypi.python.org/packages/source/c/cffi/cffi-${PV}.tar.gz"
SRC_URI[md5sum] = "ca6e6c45b45caa87aee9adc7c796eaea"
SRC_URI[sha256sum] = "390970b602708c91ddc73953bb6929e56291c18a4d80f360afa00fad8b6f3339"

inherit setuptools

S = "${WORKDIR}/cffi-${PV}"

DEPENDS = "libffi python-pycparser"
