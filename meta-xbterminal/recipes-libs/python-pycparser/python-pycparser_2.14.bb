DESCRIPTION = "Parser of the C language, written in pure Python"
HOMEPAGE = "https://github.com/eliben/pycparser"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8fb364772b1441821d391591f340c35a"

SRC_URI = "https://pypi.python.org/packages/source/p/pycparser/pycparser-${PV}.tar.gz"
SRC_URI[md5sum] = "a2bc8d28c923b4fe2b2c3b4b51a4f935"
SRC_URI[sha256sum] = "7959b4a74abdc27b312fed1c21e6caf9309ce0b29ea86b591fd2e99ecdf27f73"

inherit setuptools

S = "${WORKDIR}/pycparser-${PV}"

BBCLASSEXTEND = "native"
