require ${BPN}.inc

PR = "${INC_PR}.0"

RDEPENDS_${PN} += "\
    gst1.0-fsl-plugin \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    "
