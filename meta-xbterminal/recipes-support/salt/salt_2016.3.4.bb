require ${BPN}.inc

PR = "r3"

LIC_FILES_CHKSUM = "file://LICENSE;md5=fb92f464675f6b5df90f540d60237915"

SRCNAME = "salt"
SRC_URI = "https://files.pythonhosted.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://grains.conf \
           file://master.conf \
           file://modules.conf \
"


SRC_URI[md5sum] = "9a110f379d8af6be9b0a692430cc17a6"
SRC_URI[sha256sum] = "5d4c822719d7fb2d79b0103cd9b015d251300890f8aa174e16b73fcfd6eb22f9"

RDEPENDS_${PN}-minion = "python  ${PN}-common (= ${EXTENDPKGV}) python-pycrypto python-msgpack python-pyzmq (>= 13.1.0) procps python-apt"
FILES_${PN}-minion = "${bindir}/${PN}-minion ${sysconfdir}/${PN}/minion.d/ ${CONFFILES_${PN}-minion} ${bindir}/${PN}-proxy"

RDEPENDS_${PN}-common = "python python-dateutil python-jinja2 python-pyyaml python-requests (>= 1.0.0) python-tornado (>= 4.2.1) python-futures"

RDEPENDS_${PN}-ssh = "python  ${PN}-common (= ${EXTENDPKGV}) python-msgpack"

RDEPENDS_${PN}-api = "python ${PN}-master"

RDEPENDS_${PN}-master = "python  ${PN}-common (= ${EXTENDPKGV}) python-pycrypto python-msgpack python-pyzmq (>= 13.1.0)"
FILES_${PN}-master = "${bindir}/${PN} ${bindir}/${PN}-cp ${bindir}/${PN}-key ${bindir}/${PN}-master ${bindir}/${PN}-run ${bindir}/${PN}-unity ${bindir}/spm ${CONFFILES_${PN}-master}"

RDEPENDS_${PN}-syndic = "python  ${PN}-master (= ${EXTENDPKGV})"

RDEPENDS_${PN}-cloud = "python  ${PN}-common (= ${EXTENDPKGV})"

# Avoid a QA Warning triggered by the test package including a file
# with a .a extension
INSANE_SKIP_${PN}-tests += "staticdev"
