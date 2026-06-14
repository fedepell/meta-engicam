
inherit bundle

RAUC_BUNDLE_FORMAT = "verity"

RAUC_BUNDLE_COMPATIBLE = "gwcv5"

RAUC_BUNDLE_SLOTS = "rootfs"
RAUC_SLOT_rootfs = "engicam-gwc"

# Just test keys, to be properly done!
RAUC_KEY_FILE = "/home/fede/yocto/fsl-community-bsp/sources/meta-rauc/scripts/openssl-ca/dev/private/development-1.key.pem"
RAUC_CERT_FILE = "/home/fede/yocto/fsl-community-bsp/sources/meta-rauc/scripts/openssl-ca/dev/development-1.cert.pem"
