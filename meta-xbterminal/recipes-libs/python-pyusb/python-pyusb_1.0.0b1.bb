DESCRIPTION = "PyUSB provides USB access on the Python language"
HOMEPAGE = "https://walac.github.io/pyusb/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a53a9c39efcfb812e2464af14afab013"

SRC_URI = "https://pypi.python.org/packages/source/p/pyusb/pyusb-${PV}.tar.gz"
SRC_URI[md5sum] = "5cc9c7dd77b4d12fcc22fee3b39844bc"
SRC_URI[sha256sum] = "6fa787840baa8c6a041e370bf381127aae5fb44c820ba655f966b7da4de6279f"

S = "${WORKDIR}/pyusb-${PV}"

inherit setuptools

DEPENDS = "libusb1"
