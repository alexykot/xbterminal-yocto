DESCRIPTION = "A backport of recent additions to the 'collections.abc' module."
HOMEPAGE = "https://github.com/cython/backports_abc"
LICENSE = "Python-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=dd98d01d471fac8d8dbdd975229dba03"

PR = "r0"

SRC_URI += " file://LICENSE"
SRC_URI[md5sum] = "0b65a216ce9dc9c1a7e20a729dd7c05b"
SRC_URI[sha256sum] = "8b3e4092ba3d541c7a2f9b7d0d9c0275b21c6a01c53a61c731eba6686939d0a5"

inherit pypi

PYPI_PACKAGE = "backports_abc"
PYPI_PACKAGE_HASH = "f5d01d02695c0dd4f0cf01a35c03087c22338a4f72e24e2865791ebdb7a45eac"
