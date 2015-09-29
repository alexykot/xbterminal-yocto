DESCRIPTION = "Python HTTP for Humans."
HOMEPAGE = "http://python-requests.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c7869e52c8275537186de35e3cd5f9ec"

SRC_URI = "https://pypi.python.org/packages/source/r/requests/requests-${PV}.tar.gz"
SRC_URI[md5sum] = "02214b3a179e445545de4b7a98d3dd17"
SRC_URI[sha256sum] = "53c68313c5c6149b1a899234c000296e60a8900682accf73d6f0c6d608afc6b1"

S = "${WORKDIR}/requests-${PV}"

inherit setuptools
