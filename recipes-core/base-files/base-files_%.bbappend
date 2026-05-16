

do_install:append () {
    cat >> ${D}${sysconfdir}/fstab <<EOF

# GWCv4 data partition on /mnt
/dev/ubi1_0             /mnt            ubifs   defaults 0 0

EOF
}
