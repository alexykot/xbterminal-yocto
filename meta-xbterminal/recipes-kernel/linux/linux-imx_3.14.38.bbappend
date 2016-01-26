# PREMIRRORS += "git://git.freescale.com/imx/linux-2.6-imx.git git://repo.xbthq.co.uk/mirrors/linux-2.6-imx.git \n"

# Source: http://git.freescale.com/git/cgit.cgi/imx/meta-fsl-bsp-release.git/tree/imx/meta-bsp/recipes-kernel/linux/linux-imx_3.14.38.bb?h=fido_3.14.38_6UL_ga
do_configure_prepend_imx6ulevk() {
   # copy latest defconfig for imx_v7_defconfig to use
   cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/.config
   cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/../defconfig
}
