# Copyright (C) 2012-2014 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc
DEPENDS += "flex-native bison-native"

DESCRIPTION = "U-Boot based on mainline U-Boot used by FSL Community BSP in \
order to provide support for some backported features and fixes, or because it \
was submitted for revision and it takes some time to become part of a stable \
version, or because it is not applicable for upstreaming."
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

PROVIDES += "u-boot"

SRC_URI = "git://github.com/engicam-stable/u-boot-engicam_2019.04;protocol=git;branch=u-boot-engicam_2019.04_4.19.35"

SRCREV = "eb36ac2e1669d8e7dd1b23bc302b12e26077ed0c"

S = "${WORKDIR}/git"
SRC_URI += "file://0003-Add-target-to-generate-initial-env-201904.patch"

SRC_URI_append_microgea = " file://0004-Default-config-microgea-starterkit-201904.patch"

SRC_URI_append_gwcv4 = " file://0004-Default-config-microgea-gwcv4-201904.patch file://0005-Gcc_10_compat.patch file://0006-New_partitioning-GWCv4.patch"

inherit fsl-u-boot-localversion

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx6ul|microgea|gwcv4)"

do_patch_prepend() {
    os.system("mv ${S}/../Engicam.bmp ${S}/tools/logos/");
}



