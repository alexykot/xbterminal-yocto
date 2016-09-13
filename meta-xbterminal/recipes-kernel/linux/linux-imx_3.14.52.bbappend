INHERIT += "own-mirrors"
SOURCE_MIRROR_URL = "git://repo.xbthq.co.uk/mirrors/linux-2.6-imx.git"

FILESEXTRAPATHS_append := ":${THISDIR}/linux-imx"

# Apply custom patches from ITL
SRC_URI_imx6ulevk-itl = "\
    git://git.freescale.com/imx/linux-2.6-imx.git;branch=${SRCBRANCH} \
    file://0001_itl_apm_kernel.patch \
    file://0002_itl_apm_kernel.patch \
    "
