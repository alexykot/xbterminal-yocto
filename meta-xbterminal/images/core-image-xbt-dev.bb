require images/core-image-xbt.bb

SUMMARY = "An image that fully supports the XBTerminal device (development version)."
LICENSE = "MIT"

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_INSTALL_append = " openssh-sftp-server curl python-pip mc"
