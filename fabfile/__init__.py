from fabric.api import env

import build  # noqa

try:
    import build_itl  # noqa
except ImportError:
    pass

try:
    import deploy  # noqa
except ImportError:
    pass

env.use_ssh_config = True
