require ${BPN}.inc

PR = "${INC_PR}.10"

RDEPENDS_${PN} += "\
    python-json-rpc \
    python-tornado \
    "
