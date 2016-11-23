/*
 * The New Economy Minecraft Server Plugin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.tnerevival.listeners.collections;

import com.github.tnerevival.TNE;
import com.github.tnerevival.core.collection.ListListener;
import com.github.tnerevival.core.transaction.Record;

import java.util.UUID;

/**
 * Created by creatorfromhell on 11/8/2016.
 **/
public class TransactionsListener implements ListListener {
  @Override
  public void add(Object item) {
    TNE.instance.saveManager.versionInstance.saveTransaction((Record)item);
  }

  @Override
  public void preRemove(Object item) {

  }

  @Override
  public void remove(Object item) {
    TNE.instance.saveManager.versionInstance.deleteTransaction(UUID.fromString(((Record) item).getId()));
  }
}