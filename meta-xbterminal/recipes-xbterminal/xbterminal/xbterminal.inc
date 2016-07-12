def get_pkgv(d):
    return d.getVar('XBT_PKGV', True) or d.getVar('PV', True)

PKGV = "${@get_pkgv(d)}"

SRC_URI_armv5 = " file://xbterminal-firmware_${PKGV}_armel.tar.gz"
SRC_URI_armv7a = " file://xbterminal-firmware_${PKGV}_armhf.tar.gz"

S_armv5 = "${WORKDIR}/xbterminal-firmware_${PKGV}_armel"
S_armv7a = "${WORKDIR}/xbterminal-firmware_${PKGV}_armhf"

RDEPENDS_${PN} = "\
    python-modules \
    python-dbus \
    python-imaging \
    python-pyusb \
    python-pybluez \
    python-cryptography \
    python-qrcode \
    python-requests \
    python-psutil \
    python-ntplib \
    python-protobuf \
    python-nfcpy \
    zbar \
    fswebcam \
    python-itl-bsp \
    xbterminal-init \
    "
