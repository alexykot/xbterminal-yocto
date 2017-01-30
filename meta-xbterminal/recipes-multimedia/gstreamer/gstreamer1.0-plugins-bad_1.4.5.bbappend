DEPENDS += "zbar"

EXTRA_OECONF := "${@oe_filter_out('--disable-zbar', '${EXTRA_OECONF}', d)}"
EXTRA_OECONF += " --enable-zbar "
