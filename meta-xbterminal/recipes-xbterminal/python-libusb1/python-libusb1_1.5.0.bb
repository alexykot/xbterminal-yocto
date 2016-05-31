DESCRIPTION = "Pure-python wrapper for libusb-1.0"
HOMEPAGE = "https://github.com/vpelletier/python-libusb1"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

PR = "r0"

SRC_URI[md5sum] = "d5563f591cdd48f2ab859fb1d2ad2412"
SRC_URI[sha256sum] = "88b26387c0ae5ea1d9410db1d57b9f8cbbf08e083e08e1cfaffb5fec74e230db"

inherit pypi setuptools

PYPI_PACKAGE_HASH = "109200ad3d479d73da83ee0276c48698a767f0b31be735c2bca156ca90f45648"

DEPENDS += "libusb1"

