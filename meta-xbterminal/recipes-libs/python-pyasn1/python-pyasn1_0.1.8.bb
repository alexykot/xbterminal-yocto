DESCRIPTION = "ASN.1 types and codecs"
HOMEPAGE = "https://pypi.python.org/pypi/pyasn1"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=425e62320d430219736139b134db2fc4"

SRC_URI = "https://pypi.python.org/packages/source/p/pyasn1/pyasn1-${PV}.tar.gz"
SRC_URI[md5sum] = "7f6526f968986a789b1e5e372f0b7065"
SRC_URI[sha256sum] = "5d33be7ca0ec5997d76d29ea4c33b65c00c0231407fff975199d7f40530b8347"

inherit setuptools

S = "${WORKDIR}/pyasn1-${PV}"
