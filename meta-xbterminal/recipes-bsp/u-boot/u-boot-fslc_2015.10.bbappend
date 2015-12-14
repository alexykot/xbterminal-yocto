FILESEXTRAPATHS_append := ":${THISDIR}/files"

# Fix screen issue for wandboard
SRC_URI_append_wandboard = " file://fix_config_wandboard_mmcargs.patch "
