DESCRIPTION = "Cross-platform library for retrieving information onrunning processes and system utilization in Python"
HOMEPAGE = "https://github.com/giampaolo/psutil"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0f02e99f7f3c9a7fe8ecfc5d44c2be62"

SRC_URI = "https://pypi.python.org/packages/source/p/psutil/psutil-${PV}.tar.gz"
SRC_URI[md5sum] = "b34360627efb429cb18a4a3143b18c8c"
SRC_URI[sha256sum] = "d3290bd4a027fa0b3a2e2ee87728056fe49d4112640e2b8c2ea4dd94ba0cf057"

inherit setuptools

S = "${WORKDIR}/psutil-${PV}"
