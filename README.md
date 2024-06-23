# DomainEnforcer

DomainEnforcer is a Minecraft plugin designed to enforce player connections through specific domain names, ensuring players connect using the desired URLs and not direct IP addresses.

## Features

- Enforce players to connect using specific domains.
- Provide custom messages when players connect using an IP address or an invalid domain.
- Configurable via `config.yml`.
- Commands to start, stop, and reload the plugin.
- Compatible with Minecraft versions from 1.8 to 1.20.

## Installation

1. **Download the Plugin:**
   - Download the latest version of DomainEnforcer from the [releases page](https://github.com/yourusername/DomainEnforcer/releases).

2. **Install the Plugin:**
   - Place the `DomainEnforcer.jar` file into the `plugins` directory of your Minecraft server.

3. **Start the Server:**
   - Start your Minecraft server to generate the default configuration file.

4. **Configure the Plugin:**
   - Edit the `config.yml` file located in the `plugins/DomainEnforcer` directory to suit your needs.

## Configuration

The `config.yml` file contains the following settings:

```yaml
# List of required domains players should use to connect add more domains as needed
required-domains:
  - 1.anotherdomain.com
  - 2.anotherdomain.com

# Message to display when a player connects using an IP address
ip-warning-message:
  - "---------------------------------------------"
  - "&cYou have connected using an IP address."
  - "&ePlease use one of the following domains to connect:"
  - "&a- 1.anotherdomain.com"
  - "&a- 2.anotherdomain.com"
  - "---------------------------------------------"

# Message to display when a player connects using an invalid domain
invalid-domain-message:
  - "---------------------------------------------"
  - "&cYou have connected using an invalid domain."
  - "&ePlease use one of the following domains to connect:"
  - "&a- 1.anotherdomain.com"
  - "&a- 2.anotherdomain.com"
  - "---------------------------------------------"
```

## Commands

- `/domainenforcer reload` - Reloads the plugin configuration.
- `/domainenforcer start` - Starts the DomainEnforcer plugin.
- `/domainenforcer stop` - Stops the DomainEnforcer plugin.
- `/domainenforcer help` - Displays help information.

## Permissions

Currently, DomainEnforcer does not implement specific permissions for commands. This functionality may be added in future versions.

## Usage

1. **Start the Server:**
   - Ensure your server is running with DomainEnforcer installed.

2. **Configure Domains:**
   - Edit the `config.yml` to specify the required domains players should use.

3. **Manage the Plugin:**
   - Use the provided commands to start, stop, and reload the plugin as needed.

## Compatibility

DomainEnforcer is compatible with Minecraft versions from 1.8 to 1.20.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements, bug fixes, or features.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Support

For support, please create an issue on the [GitHub issues page](https://github.com/yourusername/DomainEnforcer/issues) or contact us on the Spigot forum thread.

---

Thank you for using DomainEnforcer! We hope it enhances your server's security and player experience.
