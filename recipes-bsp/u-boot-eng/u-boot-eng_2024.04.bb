# Copyright (C) 2012-2014 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc
DEPENDS += "flex-native bison-native"

DESCRIPTION = "U-Boot based on mainline U-Boot used by FSL Community BSP in \
order to provide support for some backported features and fixes, or because it \
was submitted for revision and it takes some time to become part of a stable \
version, or because it is not applicable for upstreaming."
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

PROVIDES += "u-boot"

SRC_URI = "git://github.com/engicam-stable/u-boot-engicam-2024.04;protocol=https;branch=eng_v2024.04"
SRC_URI[sha256sum] = "76f0a3e5a1a402e9e9f8ed59be0c809baa2eaf71c7084a2577ef32b39f3a8d12"


SRCREV = "dc8f4c53bae8ba381d2956bdb8419273830ca088"

# TODO: GWC customizations to be redefined and readded as needed
# SRC_URI:append:gwcv4 = " file://0004-Default-config-microgea-gwcv4-201904.patch file://0005-Gcc_10_compat.patch file://0006-New_partitioning-GWCv4.patch \
#                         file://0007-Add-DTB-calculation-from-pins.patch file://0008-Disable_PHY_before_boot.patch file://0009-Uboot_password.patch

inherit fsl-u-boot-localversion

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx6ul|microgea|gwcv4)"

do_patch:prepend() {
    os.system("mv ${S}/../Engicam.bmp ${S}/tools/logos/");
}


do_install:append() {
    cd ${DEPLOY_DIR_IMAGE}
    ln -sf u-boot.bin u-boot.bin.tagged
}

ERROR_QA:remove = "patch-status"
