

do_install:append () {
    # TODO: put back, is annoying otherwise will be timeouting during devel
    cat >> ${D}${sysconfdir}/fstab <<EOF

# GWCv4 data partition on /mnt
# /dev/ubi1_0             /mnt            ubifs   defaults 0 0

EOF

    # TODO: integrate better in u-boot-initial-env (if we have a more standard uboot)
    cat >> ${D}${sysconfdir}/fw_env.config <<EOF
# GWC U-boot environment positioning on flash
/dev/mtd0               0x1C0000        0x2000         0x40000

EOF

}
