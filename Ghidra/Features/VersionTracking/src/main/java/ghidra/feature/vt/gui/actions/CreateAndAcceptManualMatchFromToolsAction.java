/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.feature.vt.gui.actions;

import docking.action.MenuData;
import ghidra.feature.vt.gui.plugin.VTController;
import ghidra.feature.vt.gui.plugin.VTPlugin;
import ghidra.feature.vt.gui.task.CreateAndAcceptApplyManualMatchTask;
import ghidra.feature.vt.gui.task.CreateManualMatchTask;
import ghidra.program.model.listing.Function;
import ghidra.util.HelpLocation;

public class CreateAndAcceptManualMatchFromToolsAction extends AbstractManualMatchFromToolsAction {

	public CreateAndAcceptManualMatchFromToolsAction(VTPlugin plugin) {
		super(plugin, "Create And Accept Manual Match From Tool");
		String menuGroup = "1"; // first group in the popup
		setPopupMenuData(new MenuData(
			new String[] { VTPlugin.MATCH_POPUP_MENU_NAME, "Create And Accept Manual Match" },
			CreateManualMatchAndAcceptAction.ICON, menuGroup));
		setHelpLocation(new HelpLocation("VersionTrackingPlugin",
			"Create_And_Accept_Manual_Match_From_Subtools"));

	}

	@Override
	protected CreateManualMatchTask getTask(VTController controller, Function sourceFunction,
			Function destinationFunction) {
		return new CreateAndAcceptApplyManualMatchTask(controller, sourceFunction,
			destinationFunction, false);
	}
}
