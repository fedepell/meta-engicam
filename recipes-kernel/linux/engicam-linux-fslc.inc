# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native linux-firmware wireless-regdb"

# At the upgrade to 5.4.296 moved to fedepell fork as upstream (Freescale)
# is not updating anymore 5.4.x since 5.4.224
SRC_URI = "git://github.com/fedepell/linux-fslc.git;branch=${SRCBRANCH} \
           file://0001-add-dts.patch \
           file://0002-Add_idscount.patch \
           file://0005-ADC_support.patch \
           file://0006-DTB_phy_reset_changes.patch \
           file://gen_dts.sh \
           file://defconfig"

LOCALVERSION = "-gwcv4"

# Removed patches since upstreamed with last bump from 5.4.122 to 5.4.296:
#           file://0003-Fix_MX6_gpminand_clock.patch
#           file://0004-Quectel_serial_modem_support.patch

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

S = "${WORKDIR}/git"

# We need to pass it as param since kernel might support more then one
# machine, with different entry points
#KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

KERNEL_EXTRA_ARGS_mx6 += "LOADADDR=0x10008000"

KERNEL_EXTRA_ARGS_mx6sx += "LOADADDR=0x80008000"

KERNEL_EXTRA_ARGS_mx6ull += "LOADADDR=0x80008000"

KERNEL_EXTRA_ARGS_mx6ul += "LOADADDR=0x80008000"

KERNEL_EXTRA_ARGS_mx6sx += "LOADADDR=0x80008000"

LINUX_VERSION_EXTENSION="-gwcv4"

COMPATIBLE_MACHINE = "(mx6|mx6ul|mx6sx)"

kernel_do_configure_append() {
    echo "CONFIG_EXTRA_FIRMWARE_DIR=\"${WORKDIR}/recipe-sysroot/lib/firmware/\"" >> ${B}/.config
}

# Generate the blob of all DTS for GWCv4 with the supplied shell script tool
# and then install that file to the deployment directory with images along other images
kernel_do_install_append() {
    cd arch/arm/boot/dts
    ${WORKDIR}/gen_dts.sh
    install -m 0644 gwcv4-dtbs.bin ${DEPLOY_DIR_IMAGE}
}
